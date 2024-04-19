import React from 'react';
import { Link } from 'react-router-dom';
import Login from './Login';
import image from '../images/image.jpeg';
import image1 from '../images/image1.jpeg';
import { Element, animateScroll as scroll, scroller } from 'react-scroll';


const HomePage = () => {
const scrollToAbout = () => {
    scroller.scrollTo('about-section', {
      duration: 800,
      delay: 0,
      smooth: 'easeInOutQuart'
    });
  };
  return (
    <div>
      <div className="header">
        <div className="login-buttons">
        <Link to="/Login">
          <button>Login</button>
          </Link>
          <Link to="/Register">
          <button>Register</button>
          </Link>
        </div>
      </div>
      <div style={{ position: 'relative' }}>
        <img src={image} alt="Your Image Alt Text" style={{ width: '1920px', height: '557px',opacity: '1.0' }} />
        <h1 style={{ position: 'absolute', top: '30%', left: '51%', transform: 'translate(-50%, -50%)', color: '#363062', zIndex: '1',fontSize: '55px', fontWeight: 'bold' }}>International <br /> Student Hub</h1>
        <button onClick={scrollToAbout} style={{ position: 'absolute', top: '75%', left: '50%', transform: 'translate(-50%, -50%)', zIndex: '1', fontSize: '24px', backgroundColor: '#363062', border: '1px solid #363062', padding: '10px 20px', cursor: 'pointer', borderRadius: '10px' }}>What do we do?</button>
      </div>
     <Element name="about-section" className="element" style={{ textAlign: 'center', color: '#363062', fontSize: '36px', marginTop: '50px', position: 'relative' }}>
           <h2>About Us</h2>
           <div>
             <div style={{ position: 'absolute', top: '133px', left: '362px', width: '445px', height: '387px', backgroundColor: '#F99417', zIndex: '1',display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
               <p style={{ color: '#FFFFFF', fontSize: '18px', textAlign: 'center',left: '372px', width:'80%', height:'60%' }}>Each year several international students arrive in the United States of America, to pursue higher education. However, despite the opportunities and academic resources available, these students often face challenges in adapting to a new country, and its culture.
                                                                                      A common struggle is forming connections with peers from similar backgrounds, who could assist each other in navigating the different aspects of life in the U.S</p>
             </div>
             <div style={{ position: 'absolute', top: '230px', left: '474px', width: '393px', height: '327px', backgroundColor: '#4D4C7D', zIndex: '0' }}></div>
             <div style={{ position: 'absolute', top: '133px', left: '1100px', width: '445px', height: '387px', backgroundColor: '#F99417', zIndex: '1',display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
                       <p style={{ color: '#FFFFFF', fontSize: '18px', textAlign: 'center',left: '484px', width:'80%', height:'60%' }}>This platform aims to assist international students steering through life away from home, through helping them in creating a network with other students, industry professionals, cultivating a supportive community, improving their local living experience, and promoting a sense of appreciation of diverse individuals and cultures.</p>
                     </div>
                     <div style={{ position: 'absolute', top: '230px', left: '1212px', width: '393px', height: '327px', backgroundColor: '#363062', zIndex: '0' }}></div>
           </div>
         </Element>
         {/* This div represents the rectangle section positioned below the square sections */}
         <div style={{
           marginTop: '600px', // Adjust this value as needed to ensure there's no overlap
           width: '1700px',
           height: '300px',
           backgroundColor: '#4D4C7D', // Example background color
           borderRadius: '8px', // To slightly round the corners
           display: 'flex',
           flexDirection: 'column',
           justifyContent: 'flex-start', // Center the text horizontally
           alignItems: 'center', // Center the text vertically
           marginLeft: 'auto', // These two lines center the div horizontally
           marginRight: 'auto',
           clipPath: 'polygon(5% 0.3%, 95% 0.5%, 100% 12.8%, 100% 88.8%, 95.7% 100%, 4.4% 99.8%, 0% 89.5%, 0% 12.5%)' // Slightly chipped sides


         }}>
         {/* Header text with specified styling */}
                    <h2 style={{
                      fontWeight: 'bold', // Make the text bold
                      color: '#F99417', // Example color change
                      textAlign: 'left', // Left align text
                      width: '80%', // Ensures it's not completely left aligned
                      fontSize: '48px', // Increase font size
                      marginTop: '25px', // Add some space between the top edge and the h2
                      marginBottom: '30px',
                      marginLeft: '45px',

                    }}>
                      This is your platform!
                    </h2>
           {/* Paragraph text with specified styling */}
           <p style={{
            fontWeight: 'bold',
            marginTop: '15px',
             color: '#FFFFFF', // Example color change for the paragraph
             textAlign: 'right-center', // Center align text
              // Control the width of the paragraph for better readability
             fontSize: '25px', // Adjust font size as desired
             // Add some space between the h2 and the paragraph
             marginBottom: '20px', // Add some space between the bottom edge and the p
             marginLeft: '380px', // Move the p to the right
              // Move the p 50px to the left
           }}>
             We foster a vibrant community that thrives on collaboration and support. The platform is your space to empower and be empowered by sharing your voice, connecting with others, and making the most of your academic and personal journey.
           </p>
         </div>

         <Element name="services-section" className="element" style={{ textAlign: 'center', color: '#363062', fontSize: '32px', marginTop: '140px', position: 'relative' }}>
                    <h2>Become a part of our community of international students.</h2>
                  </Element>


        <div style={{ display: 'flex', justifyContent: 'space-around', marginTop: '70px' }}>
          {/* First square */}
          <div style={{ width: '445px', height: '387px', backgroundColor: '#F99417', position: 'relative', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
            {/* Inner square with text */}
            <div style={{ width: '380px', height: '300px', backgroundColor: '#4D4C7D', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
              <div>
                    <h2 style={{ color: '#F99417', fontSize: '28px',textAlign: 'center' }}>Events</h2>
                    <ul>
                      <li style={{ color: '#F99417', fontSize: '18px'}}>Browse through the numerous professional and cultural events.</li>
                      <li style={{ color: '#F99417', fontSize: '18px'}}>Attend events to promote community building.</li>
                    </ul>
                  </div>
                </div>
              </div>

          {/* Second square */}
          <div style={{ width: '445px', height: '387px', backgroundColor: '#F99417', position: 'relative', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
            {/* Inner square with text */}
            <div style={{ width: '380px', height: '300px', backgroundColor: '#4D4C7D', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
              <div>
                                  <h2 style={{ color: '#F99417', fontSize: '28px',textAlign: 'center' }}>Networking</h2>
                                  <ul>
                                    <li style={{ color: '#F99417', fontSize: '18px'}}>Join group/forums based on your interests.</li>
                                    <li style={{ color: '#F99417', fontSize: '18px'}}>Connect with professionals froms your field to gain professional and academic help.</li>
                                   <li style={{ color: '#F99417', fontSize: '18px'}}>Get insights about companies and interview tips and techniques.</li>
                                   <li style={{ color: '#F99417', fontSize: '18px'}}>Establish social connections.</li>
                                  </ul>
                                </div>
                              </div>
                            </div>

          {/* Third square */}
          <div style={{ width: '445px', height: '387px', backgroundColor: '#F99417', position: 'relative', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
            {/* Inner square with text */}
            <div style={{ width: '380px', height: '300px', backgroundColor: '#4D4C7D', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
                <div>
                                  <h2 style={{ color: '#F99417', fontSize: '28px',textAlign: 'center', marginTop: '0px'}}>Local Recommendations</h2>
                                  <ul>
                                    <li style={{ color: '#F99417', fontSize: '18px'}}>Explore different resturants, cafes near you.</li>
                                    <li style={{ color: '#F99417', fontSize: '18px'}}>Share recommendations for local events, and places with others. .</li>

                                  </ul>
                                </div>
                              </div>
                            </div>
      </div>
      {/* Image after the three boxes */}
          <div style={{ position: 'relative' }}>
            <img src={image1} alt="Your Image Alt Text" style={{ width: '1920px', height: '507px', opacity: '0.92',marginTop: '140px' }} />
          </div>

    </div>
  );
};



export default HomePage;
