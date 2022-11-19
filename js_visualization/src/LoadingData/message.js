import { csvFormat } from "d3";

const message = (data) => {
  let message = Math.round(csvFormat(data).length / 1024) + "kB, ";
  message += data.length + " Rows, ";
  message += data.columns.length + " Columns.";
  return message;
};

export default message;
