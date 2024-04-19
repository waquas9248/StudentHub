import React from 'react';
import { Link } from 'react-router-dom';
import image2 from '../images/image2.jpeg';

const Register = () => {
    return (
        <div>
            <div className="header2">
                <div className="login-buttons">
                    <Link to="/">
                        <button>Home</button>
                    </Link>
                    <button>Register</button>
                </div>
            </div>
            <div className="login-container">
                <div className="left-section">
                    <div className="login-box">
                           <h2 style={{ fontSize: '36px',color: '#F99417' }}>Register</h2>
                               <form>
                               <label htmlFor="Email">Email:</label><br />
                               <input type="text" id="Email" name="Email" /><br />
                                 <label htmlFor="Username">Username:</label><br />
                                  <input type="text" id="Username" name="Username" /><br />
                                  <label htmlFor="Password">Password:</label><br />
                                  <input type="Password" id="Password" name="Password" /><br />
                                  <button type="submit">Register</button>
                                </form>
                    </div>

                </div>
                <div className="right-section" style={{ backgroundImage: `url(${image2})`, backgroundSize: 'cover', backgroundPosition: 'center' }}>
                  <h1 style={{ position: 'absolute', top: '20%', left: '75%', transform: 'translate(-50%, -50%)', color: '#363062', zIndex: '1',fontSize: '55px', fontWeight: 'bold' }}>Be a part of our Community</h1>
                </div>
            </div>
        </div>
    );
};

export default Register;
