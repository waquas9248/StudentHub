import React from 'react';
import { Link } from 'react-router-dom';

const Events = () => {
    return (
        <div>
        <div className="background-image">
            <div className="header2">
                <div className="LR-buttons">
                    <Link to="/">
                        <button>Home</button>
                    </Link>
                    <Link to="/LocalRecommendation">
                        <button>Local Recommendation</button>
                    </Link>
                    <Link to="/Groups">
                        <button>Groups</button>
                    </Link>
                    <Link to="/">
                        <button>Sign Out</button>
                    </Link>
                </div>
                 <h1 style={{ position: 'absolute', top: '10%', left: '51%', transform: 'translate(-50%, -50%)', color: '#363062', zIndex: '1',fontSize: '55px', fontWeight: 'bold' }}>Share an upcoming event</h1>
            </div>

            {/* Background Image Section */}

                <div className="event-form-container">
                    <form className="event-form">
                        <div className="form-field">
                            <label>Name:</label>
                            <input type="text" name="name" placeholder="Enter your name" />
                        </div>
                        <div className="form-field">
                            <label>Email:</label>
                            <input type="email" name="email" placeholder="Enter your email" />
                        </div>
                        <div className="form-field">
                            <label>Phone:</label>
                            <input type="tel" name="phone" placeholder="Enter your phone number" />
                        </div>
                        <div className="form-field">
                            <label>Title of the Event:</label>
                            <input type="text" name="eventTitle" placeholder="Enter event title" />
                        </div>
                        <div className="form-field">
                            <label>Description:</label>
                            <textarea name="description" placeholder="Describe the event" rows="5"></textarea>
                        </div>
                        <button type="submit">Submit</button>
                    </form>
                </div>
            </div>
            </div>
    );
};

export default Events;
