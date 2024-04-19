import React from 'react';
import { Link } from 'react-router-dom';

const LocalRecommendation = () => {
    return (
        <div>
            <div className="header2">
                <div className="LR-buttons">
                    <Link to="/">
                        <button>Home</button>
                    </Link>
                    <Link to="/Events">
                      <button>Events</button>
                       </Link>
                       <Link to="/Groups">
                         <button>Groups</button>
                        </Link>
                     <Link to="/">
                    <button>Sign Out</button>
                    </Link>
                  </div>
                   </div>

                   //--------------
                             <div className="search-bar">
                                 <input type="text" placeholder="Search..." />
                                 <button>Explore</button>
                             </div>
                             //-------------------
                              <div className="section">
                                   <h2>Shops and restaurants</h2>
                                <div className="local-services">
                                        <div className="service">
                                            <h3>Resturant </h3>

                                            <p>Location:  Venue</p>
                                        </div>
                                        <div className="service">
                                            <h3>Store 1</h3>

                                            <p>Location:  Venue</p>
                                        </div>
                                        <div className="service">
                                            <h3>Store 2</h3>

                                            <p>Location:  Venue</p>
                                        </div>
                                    </div>

                              </div>
                              //-------------------
                                    <div className="section">
                                   <h2>Cultural and Educational Events </h2>
                                <div className="upcoming-events">
                                        <div className="event">
                                            <h3>Event 1 </h3>

                                            <p>Location:  Venue</p>
                                        </div>
                                        <div className="event">
                                            <h3>Event 2</h3>

                                            <p>Location:  Venue</p>
                                        </div>
                                        <div className="event">
                                            <h3>Event 3</h3>

                                            <p>Location:  Venue</p>
                                        </div>
                                    </div>

                              </div>






                         </div>
                     );
                 };


export default LocalRecommendation;
