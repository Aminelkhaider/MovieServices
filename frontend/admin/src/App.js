import Sidebar from "./components/Sidebar/Sidebar";
import Topbar from "./components/topbar/Topbar";
import "./App.css"
import Home from "./pages/Home";

import User1 from "./pages/user/user";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import UserList from "./pages/UserList/Listuser";
import ProductList from "./pages/productList/ProductList";
import Product from "./pages/product/Product";
function App() {
  return (
    <BrowserRouter>
    <div className="App">
      <Topbar> </Topbar>
      <div className="container">
    <Sidebar></Sidebar>
    <Routes >
      
      <Route exact path="/" element={<Home />}></Route>
      <Route exact path="/users" element={<UserList />}></Route>
      <Route exact path="/products/:productid" element={<Product />}></Route>
      <Route exact path="/products" element={<ProductList />}></Route>
      <Route exact path="/users/:userid" element={<User1 />}></Route>
    </Routes>
      </div>
    </div>
    </BrowserRouter>
  );
}

export default App;
