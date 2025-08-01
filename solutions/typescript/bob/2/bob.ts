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
  const question = isQuestion(message);
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

const isUpperCase = (s: string) => {
  return /[A-Z]+/.test(s) && s == s.toUpperCase();
};

const isQuestion = (message: string) => {
  return message.endsWith("?");
};
