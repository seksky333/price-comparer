export interface ProductEntryNetworkModel {
  product_name: string,
  product_model: String,
  product_price: number,
  seller: string,
  view_date:string,
  reference_url: string
}

export interface ProductListModel{
  productName: string,
  productModel: string,
  productEntries: Array<ProductListEntry>
}
export interface ProductListEntry{
  seller: string,
  productPrice: number,
  referenceUrl: string,
  viewDate: string
}

export interface ProductEntryModel {
  productName: string,
  productModel: string,
  productPrice: number,
  seller: string,
  viewDate: string,
  referenceUrl: string,
}


export async function getProducts() {
  const url = "http://localhost:8092/products";
  const response = await fetch(url);
  const body = await response.json();
  return body;
}

export async function submitProductEntry(networkModel: ProductEntryNetworkModel) {
  const url = "http://localhost:8092/products";
  const response = await fetch(url, {
    method: "POST",
    cache: "no-cache",
    headers:{"Content-Type": "application/json"},
    body: JSON.stringify(networkModel)
  });
  const isSuccess = await response.ok;
  
  console.log(isSuccess);
  return isSuccess;
}
