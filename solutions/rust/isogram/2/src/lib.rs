use std::collections::HashSet;

pub fn check(candidate: &str) -> bool {
    let mut chars = HashSet::new();
    for c in candidate.chars() {
        if !c.is_alphabetic() {
            continue;
        }
        if !chars.insert(c.to_lowercase().to_string()) {
            return false;
        }
    }

    true
}
