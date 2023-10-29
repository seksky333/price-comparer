"use client";
import { useState, useEffect } from "react";
import { ProductEntryModel, ProductEntryNetworkModel, submitProductEntry } from "../../data/products";




export default function SubmitPage() {
  const [formData, setFormData] = useState<ProductEntryModel>({
    productName: "",
    productModel: "",
    productPrice: 0.0,
    seller: "",
    viewDate: "",
    referenceUrl: "",
  });


  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, value } = event.target;
    setFormData((prevFormData) => ({ ...prevFormData, [name]: value }));
  };

  const handleSubmit = (event: React.SyntheticEvent) => {
    event.preventDefault();
    const networkModel = transformToNetworkModel(formData);
    submitEntry(networkModel);
  };

  function transformToNetworkModel(model: ProductEntryModel): ProductEntryNetworkModel {
    let aModel: ProductEntryNetworkModel = {
      product_name: model.productName,
      product_model: model.productModel,
      product_price: model.productPrice,
      seller: model.seller,
      view_date: model.viewDate,
      reference_url: model.referenceUrl
    }

    return aModel;
  };

  const submitEntry = async (networkModel: ProductEntryNetworkModel) => {
    const response = await submitProductEntry(networkModel);
    console.log(response);
  };

  useEffect(() => {
    // pick today's date
  }, []);

  // const productPrice = await getProductPrice();

  return (
    <>
      <form onSubmit={handleSubmit}
        className="flex min-h-full flex-col justify-center px-6 py-8 lg:px-8"
      >
        <div className="space-y-12">
          <div className="border-b border-gray-900/10 pb-12">
            <div className="mt-10 grid grid-cols-1 gap-x-6 gap-y-8 sm:grid-cols-6">
              <div className="sm:col-span-3">
                <label
                  htmlFor="product-name"
                  className="block text-sm font-medium leading-6 text-gray-900"
                >
                  Product Name
                </label>
                <div className="mt-2">
                  <input
                    type="text"
                    name="productName"
                    id="product-name"
                    onChange={handleChange}
                    className="block w-full rounded-md border-0 py-1.5 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
                  />
                </div>
              </div>

              <div className="sm:col-span-3">
                <label
                  htmlFor="product-model"
                  className="block text-sm font-medium leading-6 text-gray-900"
                >
                  Product Model
                </label>
                <div className="mt-2">
                  <input
                    type="text"
                    name="productModel"
                    id="product-model"
                    onChange={handleChange}
                    className="block w-full rounded-md border-0 py-1.5 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
                  />
                </div>
              </div>
              <div className="sm:col-span-2">
                <label
                  htmlFor="product-price"
                  className="block text-sm font-medium leading-6 text-gray-900"
                >
                  Price
                </label>
                <div className="mt-2">
                  <input
                    type="number"
                    name="productPrice"
                    id="product-price"
                    onChange={handleChange}
                    className="block w-full rounded-md border-0 py-1.5 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
                  />
                </div>
              </div>

              <div className="sm:col-span-2">
                <label
                  htmlFor="seller"
                  className="block text-sm font-medium leading-6 text-gray-900"
                >
                  Seller
                </label>
                <div className="mt-2">
                  <input
                    type="text"
                    name="seller"
                    id="seller"
                    onChange={handleChange}
                    className="block w-full rounded-md border-0 py-1.5 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
                  />
                </div>
              </div>

              <div className="sm:col-span-2">
                <label
                  htmlFor="view-date"
                  className="block text-sm font-medium leading-6 text-gray-900"
                >
                  View date
                </label>
                <div className="mt-2">
                  <input
                    id="view-date"
                    name="viewDate"
                    type="date"
                    onChange={handleChange}
                    className="block w-full rounded-md border-0 py-1.5 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
                  />
                </div>
              </div>
              <div className="sm:col-span-6">
                <label
                  htmlFor="reference-url"
                  className="block text-sm font-medium leading-6 text-gray-900"
                >
                  Reference url
                </label>
                <div className="mt-2">
                  <input
                    id="reference-url"
                    name="referenceUrl"
                    type="text"
                    onChange={handleChange}
                    className="block w-full rounded-md border-0 py-1.5 shadow-sm ring-1 ring-inset ring-gray-300 placeholder:text-gray-400 sm:text-sm sm:leading-6"
                  />
                </div>
              </div>
            </div>
          </div>
        </div>
        <div>
          <button
            type="submit"
            className="flex w-full justify-center rounded-md bg-emerald-500 px-3 py-1.5 text-sm font-semibold leading-6 text-white shadow-sm hover:bg-emerald-400 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600"
          >
            Submit
          </button>
        </div>
      </form>
    </>
  );
}
