enum Color {
    black,
    brown,
    red,
    orange,
    yellow,
    green,
    blue,
    violet,
    grey,
    white,
}


export function decodedValue(colors: string[]): number {

    return Number(colors
        .slice(0, 2)
        .map(c => Color[c as keyof typeof Color])
        .map(c => c.valueOf())
        .join(""));
}

