const Eye = (args) => (
  <>
    <circle cx={-args.offsetX} cy={args.offsetY} r={args.radius} />
    <circle cx={args.offsetX} cy={args.offsetY} r={args.radius} />
  </>
);

export default Eye;
