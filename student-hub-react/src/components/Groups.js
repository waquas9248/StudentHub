import React from 'react';
import { Link } from 'react-router-dom';

const Groups = () => {
    const availableGroups = ["Group 1", "Group 2", "Group 3"]; // Example list of available groups


    return (
        <div>
            <div className="header2">
                <div className="LR-buttons">
                    <Link to="/">
                        <button>Home</button>
                    </Link>
                    <Link to="/LocalRecommendation">
                        <button>Local Recommendation</button>
                    </Link>
                    <Link to="/Events">
                        <button>Events</button>
                    </Link>
                    <Link to="/">
                        <button>Sign Out</button>
                    </Link>
                </div>
            </div>

            <div className="left-section">
                <h2 style={{ marginBottom: '300px' }}>Available Groups</h2>
                <div className="group-list">
                    {availableGroups.map(group => (
                        <div key={group}>{group}</div>
                    ))}
                </div>
            </div>

            <div className="right-section">
                <h2>Recent Posts - Group Name</h2>
                <div className="post-list">


                </div>
            </div>
        </div>
    );
};

export default Groups;
