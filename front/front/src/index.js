import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import HomePage from './views/home_page/home';
import ProfilePage from './views/profile_page/profile';
import ProductList from './views/products_list/productlist';
import ProductDetails from './views/product_details/product_details';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';


const router = createBrowserRouter([
  {
    path: "/",
    element: <HomePage />,
  },
  {
    path: "/home",
    element: <HomePage />,
  },
  {
    path: "/profile",
    element: <ProfilePage />,
  },

  
  {
    path: "/products",
    element: <ProductList />,
  },

  {
    path: "/products-details/:id", // path variable
    element: <ProductDetails />,
  },

  
]);


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);


reportWebVitals();
