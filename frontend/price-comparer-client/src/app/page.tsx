"use client";

import { useState, useEffect } from "react";
import { ProductListModel, getProducts } from "../data/products";

export default function Home() {
  const [productList, setProductList] = useState<Array<ProductListModel>>([]);

  const fetchProductPrice = async () => {
    const data = await getProducts();
    console.log(data.products);
    setProductList(data.products);
  };

  useEffect(() => {
    fetchProductPrice();
  }, []);

  return (
    <main>
      {productList.map((product) => {
        return (
          <section key={product.productModel}>
                  <h2 className="py-4 text-2xl font-bold leading-7 text-gray-900 sm:truncate sm:text-3xl sm:tracking-tight">
                    {product.productName}
                  </h2>
            {product.productEntries.map((entry, index) => {
              return (
                <section key={index}>
                  <table className="table-auto text-center">
                    <thead className="bg-emerald-500 text-white">
                      <tr>
                        <th className="py-2 px-3 uppercase font-semibold text-sm">
                          Model
                        </th>
                        <th className="py-2 px-3 uppercase font-semibold text-sm">
                          Price
                        </th>
                        <th className="py-2 px-3 uppercase font-semibold text-sm">
                          Seller
                        </th>
                        <th className="py-2 px-3 uppercase font-semibold text-sm">
                          View Date
                        </th>
                        <th className="py-2 px-3 uppercase font-semibold text-sm">
                          Url
                        </th>
                      </tr>
                    </thead>
                    <tbody className="text-gray-700">
                      <tr>
                        <td>{product.productModel}</td>
                        <td>{entry.productPrice}</td>
                        <td>{entry.seller}</td>
                        <td>{entry.viewDate}</td>
                        <td>
                        <a className="underline hover:underline"
                        href={entry.referenceUrl} target="_blank">Reference url</a> 
                        
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </section>
              );
            })}
          </section>
        );
      })}
    </main>
  );
}
