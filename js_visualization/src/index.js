import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import reportWebVitals from './reportWebVitals';


// import SmileyApp from './smiley/SmileyApp';
// import MouseApp from './mouseFollower/MouseApp';
import LoadingDataApp from './LoadingData/LoadingDataApp';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <LoadingDataApp />
    {/* <MouseApp /> */}
    {/* <SmileyApp /> */}
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
