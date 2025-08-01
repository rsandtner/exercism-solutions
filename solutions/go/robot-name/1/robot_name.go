package robotname

import (
	"bytes"
	"errors"
	"math/rand"
	"strconv"
	"time"
)

var letters = []rune("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
var gen = &generator{names: map[string]struct{}{}}

const maxAvailableNames = 26 * 26 * 10 * 10 * 10

type Robot struct {
	name string
}

func (r *Robot) Name() (string, error) {
	if r.name != "" {
		return r.name, nil
	}

	name, err := gen.generate()
	r.name = name

	return name, err
}

func (r *Robot) Reset() {
	r.name = ""
}

type generator struct {
	names map[string]struct{}
}

func (g *generator) generate() (string, error) {

	if len(g.names) == maxAvailableNames {
		return "", errors.New("no more names left")
	}

	rand.Seed(time.Now().UnixNano())

	var name string
	for {

		buf := errBuffer{}

		buf.WriteRune(letters[rand.Intn(len(letters))]).
			WriteRune(letters[rand.Intn(len(letters))]).
			WriteString(strconv.Itoa(rand.Intn(9))).
			WriteString(strconv.Itoa(rand.Intn(9))).
			WriteString(strconv.Itoa(rand.Intn(9)))

		if buf.err != nil {
			return "", buf.err
		}

		name = buf.String()
		if _, seen := g.names[name]; seen {
			continue
		}

		g.names[name] = struct{}{}
		break
	}

	return name, nil
}

type errBuffer struct {
	b   bytes.Buffer
	err error
}

func (b *errBuffer) WriteRune(r rune) *errBuffer {

	if b.err != nil {
		return b
	}

	_, err := b.b.WriteRune(r)
	b.err = err

	return b
}

func (b *errBuffer) WriteString(s string) *errBuffer {
	if b.err != nil {
		return b
	}

	_, err := b.b.WriteString(s)
	b.err = err

	return b
}

func (b *errBuffer) String() string {
	if b.err != nil {
		return ""
	}

	return b.b.String()
}
