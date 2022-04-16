const KENDRICK_MARKER = `<img src="assets/Kendrick.png" width=120 height=120/>`;
const KEEM_MARKER = `<img src="assets/BabyKeem.png" width=120 height=120/>`;
const YE_MARKER = `<img src="assets/Kanye.png" width=120 height=120/>`;
const PETE_MARKER = `<img src="assets/Pete.png" width=120 height=120/>`;

const THEMES = [
  {
    name: "Classic",
    backgroundColor: "#ffffff",
    boardColor: "#ffffff",
    buttonColor: "#2ecc71",
    buttonColorHover: "#27ae60",
    textColor: "#000000",
    marker1: "O",
    marker2: "X",
  },
  {
    name: "Under the Sea",
    backgroundColor: "#FBE0C4",
    boardColor: "#8AB6D6",
    buttonColor: "#2978B5",
    buttonColorHover: "#0061A8",
    textColor: "#0061A8",
    marker1: "&#x1F980;",
    marker2: "&#x1F420;",
  },
  {
    name: "Space",
    backgroundColor: "#363062",
    boardColor: "#E9D5DA",
    buttonColor: "#827397",
    buttonColorHover: "#4d4C7D",
    textColor: "#E9D5DA",
    marker1: "&#x1F680;",
    marker2: "&#x1FA90;",
  },
  {
    name: "Material Gworl",
    backgroundColor: "#4C0070",
    boardColor: "#160040",
    buttonColor: "#9A0680",
    buttonColorHover: "#8e44ad",
    textColor: "#ffffff",
    marker1: "&#x1F481;&#x200D;&#x2640;&#xFE0F;",
    marker2: "&#128133;",
  },
  // {
  //   name: "Material Gworl",
  //   backgroundColor: "#9b59b6",
  //   boardColor: "#180A0A",
  //   buttonColor: "#AA7DCE",
  //   buttonColorHover: "#8e44ad",
  //   textColor: "#ffffff",
  //   marker1: "&#x1F481;&#x200D;&#x2640;&#xFE0F;",
  //   marker2: "&#128133;",
  // },
  {
    name: "Jungle",
    backgroundColor: "#206A5D",
    boardColor: "#81B21B",
    buttonColor: "#FFCC29",
    buttonColorHover: "#F58634",
    textColor: "#FFCC29",
    marker1: "&#x1F9A7;",
    marker2: "&#x1F405;",
  },
  {
    name: "USC",
    backgroundColor: "#990000",
    boardColor: "#ffffff",
    buttonColor: "#ffc72c",
    buttonColorHover: "#e6b01e",
    textColor: "#ffc72c",
    marker1: "&#x1F3C8;",
    marker2: "&#x270C;&#xFE0F;",
  },
  {
    name: "Lakers",
    backgroundColor: "#552583",
    boardColor: "#8f4acf",
    buttonColor: "#FDB927",
    buttonColorHover: "#dea323",
    textColor: "#FDB927",
    marker1: "&#x1F410;",
    marker2: "&#x1F3C0;",
  },
  {
    name: "Frozen",
    backgroundColor: "#b4cffa",
    boardColor: "#006bce",
    buttonColor: "#b4cffa",
    buttonColorHover: "#9bbdf2",
    textColor: "#006bce",
    marker1: "&#x1F427;",
    marker2: "&#x1F43B;&#x200D;&#x2744;&#xFE0F;",
  },
  {
    name: "Family Ties",
    backgroundColor: "#5C3D2E",
    boardColor: "#B85C38",
    buttonColor: "#E0C097",
    buttonColorHover: "#E0C097",
    textColor: "#E0C097",
    marker1: KENDRICK_MARKER,
    marker2: KEEM_MARKER,
  },
  {
    name: "Skete",
    backgroundColor: "#FDFEFF",
    boardColor: "#D8D9DE",
    buttonColor: "#F20505",
    buttonColorHover: "#F20505",
    textColor: "#F20505",
    marker1: YE_MARKER,
    marker2: PETE_MARKER,
  },
];
