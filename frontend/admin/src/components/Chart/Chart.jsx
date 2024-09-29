import React from 'react'
import "./Chart.css"
import {
    LineChart,
    Line,
    XAxis,
    CartesianGrid,
    Tooltip,
    ResponsiveContainer,
  } from "recharts";
const Chart = () => {
    const data = [
        {
          name: "Jan",
          "Active User": 4000,
        },
        {
          name: "Feb",
          "Active User": 3000,
        },
        {
          name: "Mar",
          "Active User": 5000,
        },
        {
          name: "Apr",
          "Active User": 4000,
        },
        {
          name: "May",
          "Active User": 3000,
        },
        {
          name: "Jun",
          "Active User": 2000,
        },
        {
          name: "Jul",
          "Active User": 4000,
        },
        {
          name: "Agu",
          "Active User": 3000,
        },
        {
          name: "Sep",
          "Active User": 4000,
        },
        {
          name: "Oct",
          "Active User": 1000,
        },
        {
          name: "Nov",
          "Active User": 4000,
        },
        {
          name: "Dec",
          "Active User": 3000,
        },
      ];
  return (
    <div className='Chart'>
        <h3 className="chartTitle">Movies Analytics</h3>
      <ResponsiveContainer width="100%" aspect={4 / 1}>
        <LineChart data={data}>
          <XAxis dataKey="name" stroke="#5550bd" />
          <Line type="monotone" dataKey="Active User" stroke="#5550bd" />
          <Tooltip />
            <CartesianGrid stroke="#e0dfdf" strokeDasharray="5 5" />
        </LineChart>
      </ResponsiveContainer>
    </div>
  )
}

export default Chart