export async function getProductPrice() {
  const url = "http://localhost:8091/prices";
  // const url = "https://seksky333.xyz/api/v1/spending/spender";
  const response = await fetch(url);
  // console.log(response.json());
  const body = await response.json();
  return body;
}
