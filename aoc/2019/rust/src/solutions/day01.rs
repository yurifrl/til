
use crate::solver::Solver;
use std::{
    io::{self, BufRead, BufReader},
    iter::successors,
};

pub struct Problem;

impl Solver for Problem {
    type Input = Vec<u64>;
    type Output1 = u64;
    type Output2 = u64;

    fn parse_input<R: io::Read>(&self, r: R) -> Vec<u64> {
        let r = BufReader::new(r);
        r.lines().flatten().flat_map(|l| l.parse()).collect()
    }

    fn solve_first(&self, input: &Vec<u64>) -> u64 {
        input.iter().cloned().map(first).sum()
    }

    fn solve_second(&self, input: &Vec<u64>) -> u64 {
        input.iter().cloned().map(second).sum()
    }
}

fn first(mass: u64) -> u64 {
    (mass / 3).saturating_sub(2)
}

fn second(mass: u64) -> u64 {
    successors(Some(module_fuel(mass)), |&m| Some(module_fuel(m)))
        .take_while(|&m| m != 0)
        .sum()
}

#[cfg(test)]
mod tests {
    use crate::solutions::day01::*;

    let v = vec![1, 2, 3];

    #[test]
    fn test_first() {
        assert_eq!(module_fuel(12), 2);
        assert_eq!(module_fuel(14), 2);
        assert_eq!(module_fuel(1969), 654);
        assert_eq!(module_fuel(100_756), 33583);
        assert_eq!(module_fuel(1), 0);
    }

    #[test]
    fn test_second() {
        assert_eq!(total_fuel_mass(14), 2);
        assert_eq!(total_fuel_mass(1969), 966);
        assert_eq!(total_fuel_mass(100_756), 50346);
    }
}
