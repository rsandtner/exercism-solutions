use std::collections::HashSet;

pub fn anagrams_for<'a>(word: &str, possible_anagrams: &[&'a str]) -> HashSet<&'a str> {
    let word_lower = word.to_lowercase();
    let chars = sorted(&word_lower);

    possible_anagrams
        .iter()
        .filter(|possible_anagram| {
            let possible_anagram = possible_anagram.to_lowercase();
            word_lower != possible_anagram && chars == sorted(&possible_anagram)
        })
        .copied()
        .collect()
}

fn sorted(word: &str) -> Vec<char> {
    let mut word: Vec<char> = word.chars().collect();
    word.sort_unstable();
    word
}
