import React, {useState, useRef, useEffect} from 'react'
import {HiMenu} from 'react-icons/hi'
import {AiFillCloseCircle} from 'react-icons/ai'
import {Link, Route, Routes} from 'react-router-dom'
import {Sidebar, Profile} from '../components'
import {client} from '../client'
import logo from '../assets/xlogo2.png'
import {userQuery} from '../utils/data'

const Home = () => {
    const [toggelSidebar, setToggleSidebar] = useState(false)
    const [user, setUser] = useState(null) 
    const userInfo = localStorage.getItem('user') !== 'undefined' ? JSON.parse(localStorage.getItem('user')) : localStorage.clear()
    
    useEffect(() => {
        const query = userQuery(userInfo?.googleId);

        client.fetch(query)
            .then((data) => {
                setUser(data[0])
            })
    }, [])

    return(
        <div className = "flex bg-gray-50 md:flex-row flex-col h-screen transaction-height duration-75 ease-out">
            <div className="hidden md:flex h-screen flex-initial">
                <Sidebar />
            </div>
            <div className="flex md:hidden flex-row">
                <HiMenu fontSize={40} className="cursor-pointer" onClick={() => setToggleSidebar(false)}/>
                <Link to="/">
                    <img src={logo} alt="logo" className="w-28"/>
                </Link>
                <Link to={`profile/${user?._id}`}>
                    <img src={user?.image} alt="123" classname="w-28"/>
                </Link>
            </div>
        </div>
    )
}

export default Home