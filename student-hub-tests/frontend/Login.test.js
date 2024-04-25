import React from 'react';
import { render } from '@testing-library/react';
import { BrowserRouter as Router } from 'react-router-dom';
import Login from './Login';

describe('Login', () => {
  test('renders Login component with form elements', () => {
    const { getByText, getByLabelText } = render(
      <Router>
        <Login />
      </Router>
    );

    expect(getByText('Home')).toBeInTheDocument();
    expect(getByText('Register')).toBeInTheDocument();
    expect(getByText('International Student Hub')).toBeInTheDocument();
    //expect(getByText('Login')).toBeInTheDocument();
    expect(getByLabelText('Username:')).toBeInTheDocument();
    expect(getByLabelText('Password:')).toBeInTheDocument();
    //expect(getByText('Login')).toBeInTheDocument();
  });
});
