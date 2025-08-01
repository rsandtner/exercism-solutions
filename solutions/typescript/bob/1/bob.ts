const responses = {
  sure: "Sure.",
  chill: "Whoa, chill out!",
  calmDown: "Calm down, I know what I'm doing!",
  fine: "Fine. Be that way!",
  whatever: "Whatever.",
} as const;

type BobsResponse = (typeof responses)[keyof typeof responses];

export function hey(conversation = ""): BobsResponse {
  const message = conversation.trim();
  if (message.length === 0) {
    return responses.fine;
  }

  const upperCase = isUpperCase(message);
  const question = message.endsWith("?");
  if (upperCase && question) {
    return responses.calmDown;
  }

  if (upperCase) {
    return responses.chill;
  }

  if (question) {
    return responses.sure;
  }

  return responses.whatever;
}

const isLetter = /[A-Za-z]/;
const isLowerCase = /[a-z]/;

const isUpperCase = (s: string) => {
  let containsLetters = false;
  let uppercase = true;

  for (const l of s) {
    if (!isLetter.test(l)) {
      continue;
    }

    containsLetters = true;

    if (uppercase && isLowerCase.test(l)) {
      uppercase = false;
    }

    if (containsLetters && !uppercase) {
      return false;
    }
  }

  return containsLetters;
};
