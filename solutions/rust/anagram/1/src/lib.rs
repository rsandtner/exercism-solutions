use std::collections::HashSet;

pub fn anagrams_for<'a>(word: &str, possible_anagrams: &[&str]) -> HashSet<&'a str> {
    let word = word.to_lowercase();
    let chars = word.chars().collect::<Vec<char>>();
    possible_anagrams
        .iter()
        .filter(|possible_anagram| {
            let possible_anagram = possible_anagram.to_lowercase();
            word != possible_anagram && chars.eq(&possible_anagram.chars().collect::<Vec<char>>())
        })
        .collect()
}
