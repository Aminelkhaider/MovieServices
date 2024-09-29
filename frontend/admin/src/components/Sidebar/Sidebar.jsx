import React , {useState} from 'react'
import "./Sidebar.css"
import {
    LineStyle,
    Timeline,
    TrendingUp,
    PermIdentity,
    Storefront,
    AttachMoney,
    BarChart,
    MailOutline,
    DynamicFeed,
    ChatBubbleOutline,
    WorkOutline,
    Report,
  } from "@material-ui/icons";
  import { Link } from "react-router-dom";
const Sidebar = () => {

  const [verify, setVerify]=useState("Home")
  return (
    <div className="Sidebar">
      <div className="sidebarWrapper">
        <div className="sidebarMenu">
            <h3 className="sidebarTitle"> Dashboard </h3>
            <ul className="sidebarItemList">
              <Link to="/" className='link' onClick={()=>setVerify("Home")}>
                <li className={`sidebarItem${verify==="Home"? " active":""}`}>
                <LineStyle className="sidebarIcon" />
              Home
                </li></Link>
                <li className="sidebarItem">
              <Timeline className="sidebarIcon" />
              Analytics
            </li>
            <li className="sidebarItem">
              <TrendingUp className="sidebarIcon" />
              Sales
            </li>
            </ul>
        </div>
        <div className="sidebarMenu">

            <h3 className="sidebarTitle">Quick Menu</h3>
          <ul className="sidebarItemList">
            <Link to="/users" className='link' onClick={()=>setVerify("Users")}>
              <li className={`sidebarItem${verify==="Users"? " active":""}`}>
                <PermIdentity className="sidebarIcon" />
                Users
              </li>
            </Link>
            <Link to="/products" className='link' onClick={()=>setVerify("products")}>
              <li className={`sidebarItem${verify==="products"? " active":""}`}>
                <Storefront className="sidebarIcon" />
                Products
              </li>
            </Link>
            <li className="sidebarItem">
              <AttachMoney className="sidebarIcon" />
              Transactions
            </li>
            <li className="sidebarItem">
              <BarChart className="sidebarIcon" />
              Reports
            </li>
          </ul>
        </div>
        <div className="sidebarMenu">
            <h3 className="sidebarTitle">Notifications</h3>
            <ul className="sidebarItemList">
            <li className="sidebarItem">
              <MailOutline className="sidebarIcon" />
              Mail
            </li>
            <li className="sidebarItem">
              <DynamicFeed className="sidebarIcon" />
              Feedback
            </li>
            <li className="sidebarItem">
              <ChatBubbleOutline className="sidebarIcon" />
              Messages
            </li>
          </ul>
        </div>
        <div className="sidebarMenu">
          <h3 className="sidebarTitle">Staff</h3>
          <ul className="sidebarItemList">
            <li className="sidebarItem">
              <WorkOutline className="sidebarIcon" />
              Manage
            </li>
            <li className="sidebarItem">
              <Timeline className="sidebarIcon" />
              Analytics
            </li>
            <li className="sidebarItem">
              <Report className="sidebarIcon" />
              Reports
            </li>
          </ul>
        </div>
      </div>
    </div>
  )
}

export default Sidebar

        /*<div className="sidebarMenu">
          <h3 className="sidebarTitle">Dashboard</h3>
          <ul className="sidebarItemList">
            <Link to="/" className="link">
            <li className="sidebarItem active">
              <LineStyle className="sidebarIcon" />
              Home
            </li>
            </Link>
            <li className="sidebarItem">
              <Timeline className="sidebarIcon" />
              Analytics
            </li>
            <li className="sidebarItem">
              <TrendingUp className="sidebarIcon" />
              Sales
            </li>
          </ul>
        </div>
        <div className="sidebarMenu">
          <h3 className="sidebarTitle">Quick Menu</h3>
          <ul className="sidebarList">

              <li className="sidebarItem">
                <PermIdentity className="sidebarIcon" />
                Users
              </li>

              <li className="sidebarItem">
                <Storefront className="sidebarIcon" />
                Products
              </li>

            <li className="sidebarItem">
              <AttachMoney className="sidebarIcon" />
              Transactions
            </li>
            <li className="sidebarItem">
              <BarChart className="sidebarIcon" />
              Reports
            </li>
          </ul>
        </div>
        <div className="sidebarMenu">
          <h3 className="sidebarTitle">Notifications</h3>
          <ul className="sidebarList">
            <li className="sidebarItem">
              <MailOutline className="sidebarIcon" />
              Mail
            </li>
            <li className="sidebarItem">
              <DynamicFeed className="sidebarIcon" />
              Feedback
            </li>
            <li className="sidebarItem">
              <ChatBubbleOutline className="sidebarIcon" />
              Messages
            </li>
          </ul>
        </div>
        <div className="sidebarMenu">
          <h3 className="sidebarTitle">Staff</h3>
          <ul className="sidebarList">
            <li className="sidebarItem">
              <WorkOutline className="sidebarIcon" />
              Manage
            </li>
            <li className="sidebarItem">
              <Timeline className="sidebarIcon" />
              Analytics
            </li>
            <li className="sidebarItem">
              <Report className="sidebarIcon" />
              Reports
            </li>
          </ul>
        </div>*/