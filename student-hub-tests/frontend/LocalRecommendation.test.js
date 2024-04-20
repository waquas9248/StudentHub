import React from 'react';
import { render } from '@testing-library/react';
import { BrowserRouter as Router } from 'react-router-dom';
import LocalRecommendation from './LocalRecommendation';

describe('LocalRecommendation', () => {
  test('renders LocalRecommendation component with search bar and sections', () => {
    const { getByText, getByPlaceholderText } = render(
      <Router>
        <LocalRecommendation />
      </Router>
    );

    expect(getByText('Home')).toBeInTheDocument();
    expect(getByText('Events')).toBeInTheDocument();
    expect(getByText('Groups')).toBeInTheDocument();
    expect(getByText('Sign Out')).toBeInTheDocument();
    expect(getByPlaceholderText('Search...')).toBeInTheDocument();


    expect(getByText('Shops and restaurants')).toBeInTheDocument();
    expect(getByText('Cultural and Educational Events')).toBeInTheDocument();
  });


});
