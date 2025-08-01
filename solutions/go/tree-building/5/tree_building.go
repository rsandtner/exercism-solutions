package tree

import (
	"fmt"
	"sort"
)

// Record is a flat representation of a tree node
type Record struct {
	ID     int
	Parent int
}

// Node is a tree node
type Node struct {
	ID       int
	Children []*Node
}

// Build builds a tree of the given records.
//
// The records must be continous and must not contain cycles.
func Build(recs []Record) (*Node, error) {

	sort.Slice(recs, func(i, j int) bool {
		return recs[i].ID < recs[j].ID
	})

	nodes := map[int]*Node{}
	for i, r := range recs {

		if i != r.ID || r.Parent > r.ID || r.ID > 0 && r.Parent == r.ID {
			return nil, fmt.Errorf("not in sequence or has bad parent: %v", r)
		}

		n := &Node{ID: r.ID}
		nodes[r.ID] = n

		if r.ID > 0 {
			nodes[r.Parent].Children = append(nodes[r.Parent].Children, n)
		}
	}

	return nodes[0], nil
}
