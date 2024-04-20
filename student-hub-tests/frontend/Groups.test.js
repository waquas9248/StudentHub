import React from 'react';
import { render } from '@testing-library/react';
import { BrowserRouter as Router } from 'react-router-dom';
import Groups from './Groups';

describe('Groups', () => {
  test('renders Groups component with available groups', () => {
    const { getByText } = render(
      <Router>
        <Groups />
      </Router>
    );


    expect(getByText('Home')).toBeInTheDocument();
    expect(getByText('Local Recommendation')).toBeInTheDocument();
    expect(getByText('Events')).toBeInTheDocument();
    expect(getByText('Sign Out')).toBeInTheDocument();


    expect(getByText('Available Groups')).toBeInTheDocument();
    expect(getByText('Group 1')).toBeInTheDocument();
    expect(getByText('Group 2')).toBeInTheDocument();
    expect(getByText('Group 3')).toBeInTheDocument();
  });


});
