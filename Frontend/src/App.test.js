import { render, screen } from '@testing-library/react';
import App from './App';

import App from './App';

import Adapter from 'enzyme-adapter-react-16';
import { shallow, configure, mount } from 'enzyme';
import Footer from './Components/HomePage/Footer';
configure({ adapter: new Adapter() });


describe('MyComponent', () => {

  it('renders Footer without crash', () => {
    shallow(<Home />);
  });
  it('renders Footer without crash', () => {
    shallow(<Footer />);
  });


});
