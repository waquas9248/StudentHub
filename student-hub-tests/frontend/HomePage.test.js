import React from 'react';
import { render, waitFor } from '@testing-library/react';
import { BrowserRouter as Router } from 'react-router-dom';
import HomePage from './HomePage';

describe('HomePage', () => {
  test('renders HomePage component with images and buttons', () => {
    const { getByText } = render(
      <Router>
        <HomePage />
      </Router>
    );

    expect(getByText('Login')).toBeInTheDocument();
    expect(getByText('Register')).toBeInTheDocument();
  });

  test('clicking on "What do we do?" button scrolls to "about-section"', async () => {
    const { container } = render(
      <Router>
        <HomePage />
      </Router>
    );

    // Wait for the element with id 'about-section' to be present in the document
    await waitFor(() => {
      const aboutSection = container.querySelector('#about-section');
      expect(aboutSection).toBeInTheDocument();
    });

    // Your test assertions here
  });

  // Add more tests for other functionalities as needed
});
