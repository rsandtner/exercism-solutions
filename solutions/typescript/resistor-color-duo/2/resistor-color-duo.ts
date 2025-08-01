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
];

type Color = typeof colors[number];
 
export function decodedValue([band1, band2]: Color[]): number {
    return colors.indexOf(band1) * 10 + colors.indexOf(band2);
}

