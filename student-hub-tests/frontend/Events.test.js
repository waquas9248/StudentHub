import React from 'react';
import { render } from '@testing-library/react';
import { BrowserRouter as Router } from 'react-router-dom';
import Events from './Events';

test('renders Events component with form elements', () => {
  const { getByLabelText, getByText } = render(
    <Router>
      <Events />
    </Router>
  );


  expect(getByLabelText('Name:')).toBeInTheDocument();
  expect(getByLabelText('Email:')).toBeInTheDocument();
  expect(getByLabelText('Phone:')).toBeInTheDocument();
  expect(getByLabelText('Title of the Event:')).toBeInTheDocument();
  expect(getByLabelText('Description:')).toBeInTheDocument();
  expect(getByText('Submit')).toBeInTheDocument();
});

test('renders Home button in Events component', () => {
  const { getByText } = render(
    <Router>
      <Events />
    </Router>
  );

  // Check that the Home button is present
  expect(getByText('Home')).toBeInTheDocument();
});

test('renders Local Recommendation button in Events component', () => {
  const { getByText } = render(
    <Router>
      <Events />
    </Router>
  );

  // Check that the Local Recommendation button is present
  expect(getByText('Local Recommendation')).toBeInTheDocument();
});

test('renders Groups button in Events component', () => {
  const { getByText } = render(
    <Router>
      <Events />
    </Router>
  );

  // Check that the Groups button is present
  expect(getByText('Groups')).toBeInTheDocument();
});

test('renders Sign Out button in Events component', () => {
  const { getByText } = render(
    <Router>
      <Events />
    </Router>
  );

  // Check that the Sign Out button is present
  expect(getByText('Sign Out')).toBeInTheDocument();
});
