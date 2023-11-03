import React from 'react';
import ReactDOM from 'react-dom/client';

// CSS
import './index.css';

import reportWebVitals from './reportWebVitals';

// Router
import RouterProject from './RouterProject';

// Browser Router
import { BrowserRouter } from 'react-router-dom';

// i18n
import "./internationalization/i18nlanguage"

// ROOT
const root = ReactDOM.createRoot(document.getElementById('root'));

// RENDER
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <RouterProject />
    </BrowserRouter>
  </React.StrictMode>
);

reportWebVitals();
