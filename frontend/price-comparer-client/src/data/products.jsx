export async function getProducts() {
  const url = "http://localhost:8091/products";
  const response = await fetch(url);
  const body = await response.json();
  return body;
}
