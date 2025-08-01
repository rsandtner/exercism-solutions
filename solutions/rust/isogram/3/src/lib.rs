use std::collections::HashSet;

pub fn check(candidate: &str) -> bool {
    let mut seen = HashSet::new();
    candidate.to_lowercase()
        .chars()
        .all(|c| seen.insert(c))
}
