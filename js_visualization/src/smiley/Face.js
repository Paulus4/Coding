import Mouth from "./Mouth";
import SmileyBackground from "./SmileyBackground";
import Eye from "./Eye";
import FaceContainer from "./FaceContainer";

const Face = ({
  width,
  height,
  smileyCenterX,
  smileyCenterY,
  eyeRadius,
  eyeOffsetX,
  eyeOffsetY,
  strokeWidth,
  mouthWidth,
  mouthRadius,
}) => (
  <FaceContainer
    width={width}
    height={height}
    centerX={smileyCenterX}
    centerY={smileyCenterY}
  >
    <SmileyBackground
      radius={smileyCenterY - strokeWidth / 2 - 10}
      strokeWidth={strokeWidth}
    />
    <Eye offsetX={eyeOffsetX} offsetY={eyeOffsetY} radius={eyeRadius} />
    <Mouth width={mouthWidth} radius={mouthRadius} />
  </FaceContainer>
);

export default Face;
