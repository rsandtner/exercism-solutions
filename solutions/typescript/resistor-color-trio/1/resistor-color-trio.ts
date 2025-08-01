const colors = [
    "black",
    "brown",
    "red",
    "orange",
    "yellow",
    "green",
    "blue",
    "violet",
    "grey",
    "white",
] as const;

type Color = typeof colors[number];

export function decodedResistorValue([band1, band2, band3]: Color[]): string {
    const ohms = calculateOhms([band1, band2, band3]);
    if (ohms < 1000) {
        return `${ohms} ohms`;
    }

    return `${ohms / 1000} kiloohms`;
}

function calculateOhms([band1, band2, band3]: Color[]): number {
    return (colors.indexOf(band1) * 10 + colors.indexOf(band2)) * Math.pow(10, colors.indexOf(band3));
}