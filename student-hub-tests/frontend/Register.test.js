import React from 'react';
import { render } from '@testing-library/react';
import { BrowserRouter as Router } from 'react-router-dom'; // Import Router
import Register from './Register';

test('renders Register component with form elements', () => {
  const { getByLabelText, getByText } = render(
    <Router basename="/">
      <Register />
    </Router>
  );


  expect(getByLabelText('Email:')).toBeInTheDocument();
  expect(getByLabelText('Username:')).toBeInTheDocument();
  expect(getByLabelText('Password:')).toBeInTheDocument();

});
