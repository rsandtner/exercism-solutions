package robotname

import (
	"errors"
	"fmt"
	"math/rand"
	"strconv"
	"time"
)

var gen *generator

const maxAvailableNames = 26 * 26 * 10 * 10 * 10

func init() {
	gen = &generator{
		names: map[string]struct{}{},
		r:     rand.New(rand.NewSource(time.Now().UnixNano())),
	}
}

// Robot represents a robot.
type Robot struct {
	name string
}

// Name returns the generated name of a robot.
func (r *Robot) Name() (string, error) {
	if r.name != "" {
		return r.name, nil
	}

	name, err := gen.generate()
	r.name = name

	return name, err
}

// Reset resets the robot to factory defaults
func (r *Robot) Reset() {
	r.name = ""
}

type generator struct {
	names map[string]struct{}
	r     *rand.Rand
}

func (g *generator) generate() (string, error) {

	if len(g.names) == maxAvailableNames {
		return "", errors.New("no more names left")
	}

	var name string
	for {

		name = generateFmt(g)
		if _, seen := g.names[name]; seen {
			continue
		}

		g.names[name] = struct{}{}
		break
	}

	return name, nil
}

func generateFmt(g *generator) string {
	return fmt.Sprintf("%c%c%03d", g.r.Intn(26)+'A', g.r.Intn(26)+'A', g.r.Intn(1000))
}

func generateConcat(g *generator) string {

	num := strconv.Itoa(g.r.Intn(1000))
	switch l := len(num); {
	case l < 2:
		num = "0" + num
	case l < 3:
		num = "00" + num
	}

	return string(rune(g.r.Intn(26)+'A')) + string(rune(g.r.Intn(26)+'A')) + num
}
