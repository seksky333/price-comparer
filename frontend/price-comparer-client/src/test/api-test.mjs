//run node api-test.mjs

import { log } from "console";
import fetch from "node-fetch";

const url = "http://localhost:8091/prices";
const response = await fetch(url);
const body = await response.json();
log(body);