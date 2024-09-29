import React from 'react'
import "./Home.css"
import FeaturedInfo from '../components/FeaturedInfo/FeaturedInfo'
import Chart from '../components/Chart/Chart'
import WidgetSm from '../components/WidgetSm/WidgetSm'
import WidgetLg from '../components/WidgetLg/WidgetLg'
const Home = () => {
  return (
    <div className='Home'>
        <FeaturedInfo/>
        <Chart />
        <div className="HomeWidgets">
            <WidgetSm />
            <WidgetLg /> 
        </div>
        </div>
  )
}

export default Home