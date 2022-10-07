package main

//func main() {
//	//inputs := []string{"Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary"}
//	inputs := []string{"Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary"}
//
//	res := electionWinner(inputs)
//	fmt.Println("===")
//	fmt.Println(res)
//}

func electionWinner(votes []string) string {
	pool := make(map[string]int)
	var cap int
	var winner string

	// Organize votes
	for _, candidate := range votes {
		pool[candidate] = pool[candidate] + 1
	}

	// Find votes cap
	for _, votes := range pool {
		if votes >= cap {
			cap = votes
		}
	}

	// Find Winner
	for name, votes := range pool {
		if votes >= cap {
			if winner < name {
				winner = name
			}
		}
	}

	//
	return winner
}
