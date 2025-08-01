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

type records []Record

func (r records) Len() int           { return len(r) }
func (r records) Less(i, j int) bool { return r[i].ID < r[j].ID }
func (r records) Swap(i, j int)      { r[i], r[j] = r[j], r[i] }

// Node is a tree node
type Node struct {
	ID       int
	Children []*Node
}

// Build builds a tree of the given records.
//
// The records must be continous and must not contain cycles.
func Build(recs []Record) (*Node, error) {

	sort.Sort(records(recs))

	m := map[int]*Node{}
	for i, r := range recs {

		if i != r.ID || r.Parent > r.ID || r.ID > 0 && r.Parent == r.ID {
			return nil, fmt.Errorf("not in sequence or has bad parent: %v", r)
		}

		n := newNode(r.ID)
		m[r.ID] = n

		if r.ID > 0 {
			if p, ok := m[r.Parent]; ok {
				p.Children = append(p.Children, n)
			} else {
				return nil, fmt.Errorf("missing parent [%d] for record [%d]", r.Parent, r.ID)
			}
		}
	}

	return m[0], nil
}

func newNode(id int) *Node {
	return &Node{ID: id}
}
