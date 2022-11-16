import "./App.css";

import Face from "./smiley/Face";

import {range} from 'd3';

const faceWidth = 200;
const faceHeight = 200;

const array = range(45);

const App = () =>
  array.map(() => (
    <Face
      width={faceWidth}
      height={faceHeight}
      smileyCenterX={faceWidth / 2}
      smileyCenterY={faceHeight / 2}
      eyeRadius={25 - Math.random() * 10}
      eyeOffsetX={40}
      eyeOffsetY={-20}
      strokeWidth={10}
      mouthWidth={5}
      mouthRadius={23}
    />
  ));

export default App;
