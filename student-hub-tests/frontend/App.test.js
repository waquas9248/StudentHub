import React from 'react';
import { render, screen } from '@testing-library/react';
import App from './App';

test('renders HomePage by default', () => {
  render(<App />);
  const homePageElement = screen.getByText(/International Student Hub/i);
  expect(homePageElement).toBeInTheDocument();
});

test('renders Login component when path is /Login', () => {
  render(<App />);
  const loginElement = screen.getByText(/Login/i);
  expect(loginElement).toBeInTheDocument();
});

test('renders Register component when path is /Register', () => {
  render(<App />);
  const registerElement = screen.getByText(/Register/i);
  expect(registerElement).toBeInTheDocument();
});



