import { useState, useEffect } from "react";
import { csv } from "d3";

import message from "./message";

const csvUrl =
  "https://gist.githubusercontent.com/curran/b236990081a24761f7000567094914e0/raw/cssNamedColors.csv";

const LoadingDataApp = () => {
  const [data, setData] = useState(null);

  useEffect(() => {
    csv(csvUrl).then((data) => {
      console.log("fetching data");
      setData(data);
    });
  }, []);

  return <pre>Data is {data ? message(data) : "Loading..."}</pre>;
};

export default LoadingDataApp;
