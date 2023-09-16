export async function getProducts() {
  const url = "http://localhost:8091/products";
  const response = await fetch(url);
  const body = await response.json();
  return body;
}

export async function submitProductEntry(data) {
  console.log(data);
  // const url = "http://localhost:8091/products";
  // const response = await fetch(url, {
  //   method: "POST",
  //   cache: "no-cache",
  //   headers:{
  //     "Content-Type": "application/json",
  //   },
  //   body: JSON.stringify(data)
  // });
  // const body = await response.json();
  // console.log(body);
  // return body;
}
