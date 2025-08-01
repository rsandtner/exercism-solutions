const colors = ["black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"] as const;

type Color = (typeof colors)[number];

type Quantity = number;

const unitNames = ["", "kilo", "mega", "giga"];

type UnitName = (typeof unitNames)[number];

type Unit = {
  name: UnitName;
  divisor: number;
};

const units = unitNames.map((name, idx) => {
  return { name, divisor: Math.pow(1000, idx) || 1 };
});

const defaultUnit = units[0];

type ResistenceWithUnit = `${Quantity} ${UnitName}ohms`;

export function decodedResistorValue([band1, band2, band3]: Color[]): ResistenceWithUnit {
  if (![band1, band2, band3].every((color) => color && colors.includes(color))) {
    return "0 ohms";
  }

  const ohms = calculateOhms([band1, band2, band3]);

  const unit =
    units.findLast((u) => {
      return ohms > u.divisor;
    }) || defaultUnit;

  return `${ohms / unit.divisor} ${unit.name}ohms`;
}

function calculateOhms([band1, band2, band3]: Color[]): Quantity {
  return (colors.indexOf(band1) * 10 + colors.indexOf(band2)) * Math.pow(10, colors.indexOf(band3));
}
