package space

// Planet is the name of the planet
type Planet string

var orbitalPeriods = map[Planet]float64{
	"Mercury": 0.2408467,
	"Venus":   0.61519726,
	"Earth":   1.0,
	"Mars":    1.8808158,
	"Jupiter": 11.862615,
	"Saturn":  29.447498,
	"Uranus":  84.016846,
	"Neptune": 164.79132,
}

const yearInSeconds = 60 * 60 * 24 * 365.25

// Age calculates the age for the given seconds on the given plaent
func Age(sec float64, p Planet) float64 {
	return sec / orbitalPeriods[p] / yearInSeconds
}
