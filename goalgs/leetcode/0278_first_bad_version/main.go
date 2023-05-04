package main

/**
 * Forward declaration of isBadVersion API.
 * @param   version   your guess about first bad version
 * @return 	 	      true if current version is bad
 *			          false if current version is good
 * func isBadVersion(version int) bool;
 */

func firstBadVersion(n int) int {
	latestBadBersion := -1
	currentVersionIsBad := false

	for ; n > 0; n-- {
		currentVersionIsBad = isBadVersion(n)

		// if current version is bad
		// and latest version is set
		// it means we got the latest bad version
		if !currentVersionIsBad && latestBadBersion != -1 {
			break
		}

		if currentVersionIsBad {
			latestBadBersion = n
		}

	}

	return latestBadBersion
}

func isBadVersion(version int) bool {
	return version == 2
}
