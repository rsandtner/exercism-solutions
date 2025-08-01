package twofer

// ShareWith returns the name of the person i share with.
func ShareWith(name string) string {

	if name == "" {
		name = "you"
	}

	return "One for " + name + ", one for me."
}
