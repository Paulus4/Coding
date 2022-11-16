import { arc } from "d3";

const Mouth = (args) => {
  const mouthArc = arc()
    .innerRadius(args.radius)
    .outerRadius(args.radius + args.width)
    .startAngle(Math.PI / 2)
    .endAngle((Math.PI * 3) / 2);

  return <path d={mouthArc()} />;
};

export default Mouth;
